package barakat.app.aggregator.entity.app;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

@Log4j2
@Configuration
public class CronProperties {


    @Value("${spring.profiles.active}")
    String profile;

    @Value("${property.path}")
    String propertyFolder;

    Boolean hasPropertyFolder = false;


    private Properties propertiesfn(File file) throws CronPropertiesException {
        if(!hasPropertyFolder){
            File folder = new File(propertyFolder);
            if(!folder.exists()){
                folder.mkdirs();
            }
            hasPropertyFolder = true;
        }
        if (file == null) {file =  new File(propertyFolder+"/cronproperties-" + profile);};
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
            return  properties;
        }catch (Exception e){
            throw new CronPropertiesException("Не удалось найти файл для учета данных крона");
        }
    }

    public void  save(String name, String value) throws CronPropertiesException {
        try {
            File file = new File(propertyFolder+"/cronproperties-" + profile);
            Properties properties  = propertiesfn(file);
            properties.setProperty(name, value);
            properties.save(new FileOutputStream(file), "сохранение данных");
        }catch (Exception e){
            throw new CronPropertiesException("Не удалось сохранить файл для учета данных крона");
        }
    }

    public String get(String name) throws CronPropertiesException {
        try {
            Properties properties  = propertiesfn(null);
            return properties.getProperty(name);
        }catch (Exception e){
            throw new CronPropertiesException("Не удалось получить данные для учета данных крона");
        }

    }
}
