package barakat.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.SendMessage;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class BarakatInvestDriverBot {
    @Value("${app.telegtam.driverbot}")
    String token;
    @Value("${app.proxy.use}")
    Boolean proxyUse;
    @Value("${app.proxy.host}")
    String proxyHost;
    @Value("${app.proxy.port}")
    Integer proxyPort;

    @Bean
    TelegramBot telegramDriverBot (){
        OkHttpClient http;
        if(proxyUse){
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            http = new OkHttpClient.Builder().proxy(proxy).build();
        }else{
            http = new OkHttpClient.Builder().build();
        }
        TelegramBot bot = new TelegramBot.Builder(token).okHttpClient(http).build();
        Keyboard keyboard = new ReplyKeyboardMarkup(
                new KeyboardButton[]{
                        new KeyboardButton("Свободен"),
                        new KeyboardButton("Занят")
                }
        );

        // Register for updates
        bot.setUpdatesListener(updates -> {
            updates.forEach(u->{
                System.out.println(u.message().toString());
                String answer = null;
                if(u.message().text().equals("Свободен")){
                    answer = "Хорошо Адильбек, за вами машина 584AEI05. Мы уведомим как появится заявка.";
                }else if(u.message().text().equals("Занят")){
                    answer = "Хорошо Адильбек. Будем ждать.";
                }else{
                    answer = "Сервис временно недоступен";
                }

                SendMessage request = new SendMessage(308851357, answer)
                        .replyMarkup(keyboard);
                bot.execute(request);
            });
            // ... process updates
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });







        return bot;
    }

    @Bean
    void work(){
        //telegramDriverBot().
    }



}
