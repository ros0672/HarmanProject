package com.example.test_app;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*
    String name;
    String email;
    String number;

    EditText name_input;
    EditText mail_input;
    EditText phone_input;
    EditText res_text;
    EditText output_text;

    Button send_button;
    Button post_button;

    Spinner task_selector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name_input = (EditText) findViewById(R.id.name_input);
        mail_input = (EditText) findViewById(R.id.mail_input);
        phone_input = (EditText) findViewById(R.id.phone_input);

        res_text = (EditText) findViewById(R.id.res_text);

        output_text = (EditText) findViewById(R.id.output_text);

        task_selector = (Spinner) findViewById(R.id.task_selector);
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.10:8080/")//changing
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ClientService clientservice = retrofit.create(ClientService.class);
        //



        send_button = (Button) findViewById(R.id.send_button);
        send_button.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            name = name_input.getText().toString();
            email = mail_input.getText().toString();
            number = phone_input.getText().toString();


            //
            Call<List<Client>> clients = clientservice.getclients();

            clients.enqueue(new Callback<List<Client>>() {
                @Override
                public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                    if (!response.isSuccessful()) {
                        res_text.setText("response code " + response.code());
                        return;
                    }
                    List<Client> clientlist = response.body();

                    for (Client cl_iter: clientlist){
                        String content = "";
                        content += "ID: " + cl_iter.getId() + "\n";
                        content += "Name: " + cl_iter.getName() + "\n";
                        content += "Mail: " + cl_iter.getEmail() + "\n";
                        content += "Phone: " + cl_iter.getPhone() + "\n";

                        res_text.setText(content);
                        //res_text.append(content);//все же этот метод для списка всех
                    }
                }


                @Override
                public void onFailure(Call<List<Client>> call, Throwable t) {
                    res_text.setText("failure " + t.getMessage());
                }

            });
            //
            //Spinner

            Integer pos = task_selector.getSelectedItemPosition();
            output_text.setText(pos.toString());
            //
        }
        });
       //place for initial code
        //Post-button
        post_button = (Button) findViewById(R.id.post_button);
        post_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name = name_input.getText().toString();
                email = mail_input.getText().toString();
                number = phone_input.getText().toString();

                Client client = new Client();
                //client.setId(0);//?
                client.setName(name);
                client.setEmail(email);
                client.setPhone(number);
                //
                final Call<Integer> resp = clientservice.createclient(client);

                resp.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (!response.isSuccessful()) {
                            output_text.setText("response code " + response.code());
                            return;
                        }

                            output_text.setText("created: id = " + response.body().toString());

                        }


                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        output_text.setText("failure " + t.getMessage() + " ");
                    }


                });
                //

            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("output", output_text.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        output_text.setText(savedInstanceState.getString("output") + " is restored!");
    }

     */

    String m1;
    Integer m1RowSize;
    Integer m1ColSize;

    String m2;
    Integer m2RowSize;
    Integer m2ColSize;

    String res;

    Integer operationId;

    EditText m1Text;
    EditText m2Text;
    EditText resText;

    Button postButton;

    Spinner taskSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        m1Text = (EditText) findViewById(R.id.res_text);
        m2Text = (EditText) findViewById(R.id.m2_text);
        resText = (EditText) findViewById(R.id.output_text);

        taskSelector = (Spinner) findViewById(R.id.task_selector);
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.10:8080/")//changing
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final TaskService taskService = retrofit.create(TaskService.class);
        //


        //place for initial code
        //Post-button
        postButton = (Button) findViewById(R.id.post_button);
        postButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                m1 = m1Text.getText().toString();
                m2 = m2Text.getText().toString();
                //Spinner
                operationId = taskSelector.getSelectedItemPosition();
                //

                //
                InputMatrix inputMatrix = new InputMatrix();

                if (!inputMatrix.hasAllowedSymbolsOnly(m1)
                        || (!inputMatrix.hasAllowedSymbolsOnly(m2))) {

                    resText.setText("Ошибка ввода - использованы посторонние символы");

                }
                else {
                    if ((inputMatrix.getColSize(m1) != inputMatrix.getColSize(m2))
                        || (inputMatrix.getRowSize(m1) != inputMatrix.getRowSize(m2))
                        || (inputMatrix.getColSize(m1) == -1)
                        || (inputMatrix.getColSize(m1) == -1)) {
                    resText.setText("Ошибка данных - неправильные размеры матриц");
                } else {

                    //Post

                    Task task = new Task();
                    task.setOperationId(operationId);

                    task.setMatrixLeft(m1);
                    task.setMatrixLeftRowSize(inputMatrix.getRowSize(m1));
                    task.setMatrixLeftColSize(inputMatrix.getColSize(m1));

                    task.setMatrixRight(m2);
                    task.setMatrixRightRowSize(inputMatrix.getRowSize(m2));
                    task.setMatrixRightColSize(inputMatrix.getColSize(m2));

                    task.setRes("unknown");

                    final Call<Integer> resp = taskService.createTask(task);

                    resp.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> response) {
                            if (!response.isSuccessful()) {
                                resText.setText("response code " + response.code());
                                return;
                            }

                            resText.setText("Wait...");

                            //Get
                            int createdId = response.body();
                            Call<Task> taskCall = taskService.getTask(createdId);

                            taskCall.enqueue(new Callback<Task>() {
                                @Override
                                public void onResponse(Call<Task> call, Response<Task> response) {
                                    if (!response.isSuccessful()) {
                                        resText.setText("response code " + response.code());
                                        return;
                                    }
                                    Task task = response.body();

                                    resText.setText(task.getRes());

                                }


                                @Override
                                public void onFailure(Call<Task> call, Throwable t) {
                                    resText.setText("failure " + t.getMessage());
                                }

                            });
                            //

                        }


                        @Override
                        public void onFailure(Call<Integer> call, Throwable t) {
                            resText.setText("failure " + t.getMessage() + " ");
                        }


                    });
                    //
                    }
                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("output", resText.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        resText.setText(savedInstanceState.getString("output"));
    }

}

