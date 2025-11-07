package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        EditText edtNumbers = findViewById(R.id.edtNumbers);
        Button btnProcess = findViewById(R.id.btnProcess);
        TextView txtEven = findViewById(R.id.txtEven);
        TextView txtOdd = findViewById(R.id.txtOdd);

        btnProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = edtNumbers.getText().toString().trim();

                if (input.isEmpty()) {
                    txtEven.setText(" Vui lòng nhập dãy số!");
                    txtOdd.setText("");
                    return;
                }

                // Tách chuỗi thành từng số
                String[] parts = input.split(",");
                ArrayList<Integer> chan = new ArrayList<>();
                ArrayList<Integer> le = new ArrayList<>();

                for (String p : parts) {
                    try {
                        int num = Integer.parseInt(p.trim());
                        if (num % 2 == 0) {
                            chan.add(num);
                        } else {
                            le.add(num);
                        }
                    } catch (NumberFormatException e) {
                        // Nếu nhập sai định dạng thì bỏ qua
                    }
                }

                // Hiển thị kết quả
                txtEven.setText("Các số chẵn: " + chan);
                txtOdd.setText("Các số lẻ: " + le);
            }
        });

        //bai5
        EditText edtString = findViewById(R.id.edtString);
        Button btnProcessString = findViewById(R.id.btnProcessString);
        TextView txtResult = findViewById(R.id.txtResult);

        btnProcessString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edtString.getText().toString().trim();

                if (input.isEmpty()) {
                    txtResult.setText("Vui lòng nhập chuỗi!");
                    return;
                }

                // Đảo ngược thứ tự từ
                String[] words = input.split(" ");
                StringBuilder reversed = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    reversed.append(words[i]);
                    if (i != 0) reversed.append(" ");
                }

                // In hoa toàn bộ chuỗi
                String result = reversed.toString().toUpperCase();

                // In thẳng ra TextView
                txtResult.setText("Chuỗi sau khi xử lý: " + result);
            }
        });
    }
}