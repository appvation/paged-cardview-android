package com.appvation.pagedcardview;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private RecyclerView cardRecyclerView;
    private CardAdapter cardAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1
        this.cardRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        this.cardRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        this.cardAdapter = new CardAdapter(this);
        this.cardRecyclerView.setAdapter(this.cardAdapter);

        // 4
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(this.cardRecyclerView);
        this.cardRecyclerView.setOnFlingListener(snapHelper);
        this.cardRecyclerView.addItemDecoration(new VerticalOffsetDecoration(this)); // 9

        // 2
        List<LocationInformation> locations = new ArrayList<>();
        locations.add(LocationInformation.create("Appvation Pty. Ltd.", "202/147 Pirie St, Adelaide"));
        locations.add(LocationInformation.create("Appvation Pty. Ltd.", "202/147 Pirie St, Adelaide"));
        locations.add(LocationInformation.create("Appvation Pty. Ltd.", "202/147 Pirie St, Adelaide"));
        locations.add(LocationInformation.create("Appvation Pty. Ltd.", "202/147 Pirie St, Adelaide"));

        // 3
        this.cardAdapter.setItems(locations);
    }

    public class VerticalOffsetDecoration extends RecyclerView.ItemDecoration {
    private Activity context;

    public VerticalOffsetDecoration(Activity context) {
        this.context = context;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        int total = parent.getAdapter().getItemCount();


        // 5
        if (position != 0 && position != total - 1)
            return;

        // 6
        Display display = context.getWindowManager().getDefaultDisplay();
        Point displaySize = new Point();
        display.getSize(displaySize);
        int displayWidth = displaySize.x;
        RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) view.getLayoutParams();
        float viewWidth = params.width;

        // 7
        int offset = (int)(displayWidth - viewWidth) / 2 ;

        // 8
        if (position == 0)
            outRect.left = offset - params.getMarginStart();

        if (position == total - 1)
            outRect.right = offset- params.getMarginEnd();
    }
}
}
