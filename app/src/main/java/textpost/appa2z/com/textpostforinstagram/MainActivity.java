package textpost.appa2z.com.textpostforinstagram;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.constraint_status)
    ConstraintLayout constraintStatus;
    private String gradientTop[];
    private String gradientBottom[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        gradientTop = getResources().getStringArray(R.array.gradientTop);
        gradientBottom = getResources().getStringArray(R.array.gradientBottom);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, width);
        constraintStatus.setLayoutParams(layoutParams);

        selectColor();
        findViewById(R.id.txt_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectColor();
            }
        });
    }
    public void selectColor(){
        int position = new Random().nextInt(gradientBottom.length);
        setBackgroundGradient(constraintStatus, gradientTop[position],gradientBottom[position]);
    }
    public void setBackgroundGradient(View view , String color1, String color2)
    {
        int[] colors = {Color.parseColor(color1),Color.parseColor(color2)};
        GradientDrawable gd = new GradientDrawable(
                GradientDrawable.Orientation.TR_BL, colors);
        gd.setCornerRadius(0f);
        view.setBackground(gd);
    }


}
