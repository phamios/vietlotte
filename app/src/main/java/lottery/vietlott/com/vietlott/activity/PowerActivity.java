package lottery.vietlott.com.vietlott.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lottery.vietlott.com.vietlott.R;
import lottery.vietlott.com.vietlott.model.SpinnerDateModel;

public class PowerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_power);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Nhập dữ liệu cho Mua bao
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Chơi thông thường");
        spinnerArray.add("Bao 5");
        spinnerArray.add("Bao 7");
        spinnerArray.add("Bao 8");
        spinnerArray.add("Bao 9");
        spinnerArray.add("Bao 10");
        spinnerArray.add("Bao 11");
        spinnerArray.add("Bao 12");
        spinnerArray.add("Bao 13");
        spinnerArray.add("Bao 14");
        spinnerArray.add("Bao 15");
        spinnerArray.add("Bao 18");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.spinner);
        sItems.setAdapter(adapter);

        // Nhập dữ liệu cho mua theo kì liên tiếp
        List<String> spinnerDate =  new ArrayList<String>();

        //lấy giá trị của ngày tháng hiện tại cho kì chơi
        String dateStr = "04/05/2010";
        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat postFormater = new SimpleDateFormat("dd MMMM, yyyy");
        String newDateStr = postFormater.format(dateObj);

        ArrayList<SpinnerDateModel> listDate = new ArrayList<>();

        final String[] select_qualification = {newDateStr};
        for (int i = 0; i < select_qualification.length; i++) {
            SpinnerDateModel stateVO = new SpinnerDateModel();
            stateVO.setTitle(select_qualification[i]);
            stateVO.setSelected(false);
            listDate.add(stateVO);
        }

        // nạp dữ liệu cho spinner của ngày tháng vừa nhận.
        spinnerDate.add(newDateStr);
        ArrayAdapter<String> adapterDate = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerDate);
        adapterDate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItemsDate = (Spinner) findViewById(R.id.spinner2);
        sItemsDate.setAdapter(adapterDate);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
