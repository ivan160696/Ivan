package info.goodline.department.learnandroid.image;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import info.goodline.department.learnandroid.BuildConfig;
import info.goodline.department.learnandroid.R;

public class ImagePickActivity extends AppCompatActivity {

    //Объявляем используемые переменные:
    private ImageView ivPhoto;
    private File currentImageFile;

    private final int REQUEST_CODE_PICK_IMAGE_GALLARY = 1;
    static final int REQUEST_CODE_IMAGE_CAPTURE = 2;
    static final int REQUEST_CAMERA_PERMISSION = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_pick);

        //Связываемся с нашим ImageView:
        ivPhoto = findViewById(R.id.ivPhoto);

        // Вешаем на кнопку обработчик нажатий
        findViewById(R.id.btnChooseImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Интент для получения всех приложений которые могут отображать изображения
                Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
                getIntent.setType("image/*");

                // Вызываем системное диалоговое окно для выбора приложения, которое умеет отображать изображения
                // и возвращать выбранную фотографию
                Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                pickIntent.setType("image/*");

                Intent chooserIntent = Intent.createChooser(getIntent, "Выберите изображение");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});
                // Запускаем приложения и ожидаем результат
                startActivityForResult(chooserIntent, REQUEST_CODE_PICK_IMAGE_GALLARY);
            }
        });

        findViewById(R.id.btnOpenCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkCameraGrantedPermission() && doRequestPermission(REQUEST_CAMERA_PERMISSION))
                    return;

                takePhoto();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);


        switch (requestCode) {
            case REQUEST_CODE_PICK_IMAGE_GALLARY:
                try {
                    //Получаем URI изображения, преобразуем его в Bitmap
                    //объект и отображаем в элементе ImageView нашего интерфейса:
                    final Uri imageUri = imageReturnedIntent.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                    ivPhoto.setImageBitmap(selectedImage);
                } catch (FileNotFoundException e) {
                    // Эта ошибка отобразится в случае если не удалось найти изображение
                    e.printStackTrace();
                }
                break;
            case REQUEST_CODE_IMAGE_CAPTURE:
                ivPhoto.setImageBitmap(getBitmap());
                break;
        }
    }

    /**
     * Получаем фотографию с камеры
     */
    private void takePhoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this,
                    "На вашем устройстве недоступна камера",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        // Создаём файл для изображения
        currentImageFile = createImageFile();

        if (currentImageFile != null) {
            // Если файл создался — получаем его URI
            Uri imageUri = FileProvider.getUriForFile(
                    this,
                    BuildConfig.APPLICATION_ID + ".fileprovider",
                    currentImageFile
            );

            // Передаём URI в камеру
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
            startActivityForResult(intent, REQUEST_CODE_IMAGE_CAPTURE);
        }
    }


    @Nullable
    private File createImageFile() {
        // Генерируем имя файла
        String filename = System.currentTimeMillis() + ".jpg";

        // Получаем приватную директорию на карте памяти для хранения изображений
        // Выглядит она примерно так: /sdcard/Android/data/info.goodline.department.learnandroid./files/Pictures
        // Директория будет создана автоматически, если ещё не существует
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        // Создаём файл
        File image = new File(storageDir, filename);
        try {
            if (image.createNewFile()) {
                return image;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Проверить права доступа к камере
     *
     * @return true - права доступа выданы
     */
    private boolean checkCameraGrantedPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * Проверить нужно ли запрашивать права доступа на текущем устройстве
     * @param requestCode - код для запроса прав доступа
     * @return true если необходимо запросить парва доступа
     */
    private boolean doRequestPermission(int requestCode) {
        // Запрашиваем права доступа только на Android 6 и выше
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                    this, new String[]{Manifest.permission.CAMERA},
                    requestCode
            );
            return true;
        }
        return false;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // Здесь обрабатывается результат выдачи прав доступа, которые мы запросили
        switch (requestCode) {
            case REQUEST_CAMERA_PERMISSION:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    takePhoto();
                }
                break;
        }
    }

    /**
     * // https://stackoverflow.com/questions/14066038/why-does-an-image-captured-using-camera-intent-gets-rotated-on-some-devices-on-a
     *
     * @return
     */
    private Bitmap getBitmap() {
        Bitmap bitmap = BitmapFactory.decodeFile(currentImageFile.getAbsolutePath());
        try {
            ExifInterface ei = new ExifInterface(currentImageFile.getAbsolutePath());

            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION,
                    ExifInterface.ORIENTATION_UNDEFINED);

            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return rotateImage(bitmap, 90);
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return rotateImage(bitmap, 180);
                case ExifInterface.ORIENTATION_ROTATE_270:
                    return rotateImage(bitmap, 270);
                case ExifInterface.ORIENTATION_NORMAL:
                default:
                    return bitmap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }
}
