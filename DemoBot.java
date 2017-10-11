import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class DemoBot extends TelegramLongPollingBot {
    long chat_id;
    String f_id;

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            String mesage_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            if (update.getMessage().getText().equals("/start")) {
                SendMessage message = new SendMessage()
                        .setChatId(chat_id)
                        .setText("You Send /start");
                InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                List<InlineKeyboardButton> rowInline = new ArrayList<>();
                rowInline.add(new InlineKeyboardButton().setText("Update message").setCallbackData("Update _ msg "));
                rowsInline.add(rowInline);
                inlineKeyboardMarkup.setKeyboard(rowsInline);
                message.setReplyMarkup(inlineKeyboardMarkup);
                try {
                    execute(message); // Sending our message object to user
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            } else {

            }

        } else if (update.hasCallbackQuery()) {



        }


    }




        @Override
        public String getBotUsername () {
            return "Coming_soonbot";
        }

        @Override
        public String getBotToken () {
            return "472067082:AAFJUv6TS24tern05NdgofxKHv6y3yTS3Gc";
        }
    }


