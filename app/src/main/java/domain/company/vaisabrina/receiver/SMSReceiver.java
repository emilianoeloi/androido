package domain.company.vaisabrina.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.ObbInfo;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import domain.company.vaisabrina.AlunoDAO;

/**
 * Created by emiliano on 7/20/17.
 */

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "SMS Chegou", Toast.LENGTH_LONG).show();
//        Bundle bundle = intent.getExtras();
//
//        Object messages[] = (Object[]) bundle.get("pdus");
//        String formato = (String) bundle.get("format");
//
//        SmsMessage smsMessage[] = new SmsMessage[messages.length];
//        for (int n = 0; n < messages.length; n++) {
//            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
//        }
//
//        AlunoDAO dao = new AlunoDAO(context);
//
//        if(dao.isAluno(smsMessage[0].getDisplayOriginatingAddress())) {
//            Toast.makeText(context, "SMS de Aluno: " + smsMessage[0].getMessageBody(), Toast.LENGTH_LONG).show();
//        }
//        dao.close();
    }
}
