package barakat.app.aggregator.entity.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public final class CronProperties {

    public static void  save(String name, String value) throws CronPropertiesException {
        File file = new File("./cronproperties");
        if(!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception e){
                throw new CronPropertiesException("Не удалось создать файл для учета данных крона");
            }
        }
        try {
            Properties properties  = new Properties();
            properties.load(new FileInputStream(file));
            properties.setProperty(name, value);
            properties.save(new FileOutputStream(file), "сохранение данных");
        }catch (Exception e){
            throw new CronPropertiesException("Не удалось найти файл для учета данных крона");
        }
    }

    public static String get(String name) throws CronPropertiesException {
        try {
            File file = new File("./cronproperties");
            if(!file.exists()){
                try {
                    file.createNewFile();
                }catch (Exception e){
                    throw new CronPropertiesException("Не удалось создать файл для учета данных крона");
                }
            }
            Properties properties  = new Properties();
            properties.load(new FileInputStream(file));
            return properties.getProperty(name);
        }catch (Exception e){
            throw new CronPropertiesException("Не удалось найти файл для учета данных крона");
        }

    }
}
