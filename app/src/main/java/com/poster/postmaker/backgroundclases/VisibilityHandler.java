package com.poster.postmaker.backgroundclases;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class VisibilityHandler {

    public static void visibleLayout(int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5) {
        if (i == 1) {
            relativeLayout.setVisibility(0);
            relativeLayout2.setVisibility(8);
            relativeLayout3.setVisibility(8);
            relativeLayout4.setVisibility(8);
            relativeLayout5.setVisibility(8);
        } else if (i == 2) {
            relativeLayout2.setVisibility(0);
            relativeLayout.setVisibility(8);
            relativeLayout3.setVisibility(8);
            relativeLayout4.setVisibility(8);
            relativeLayout5.setVisibility(8);
        } else if (i == 3) {
            relativeLayout2.setVisibility(8);
            relativeLayout.setVisibility(8);
            relativeLayout3.setVisibility(0);
            relativeLayout4.setVisibility(8);
            relativeLayout5.setVisibility(8);
        } else if (i == 4) {
            relativeLayout2.setVisibility(8);
            relativeLayout.setVisibility(8);
            relativeLayout3.setVisibility(8);
            relativeLayout4.setVisibility(0);
            relativeLayout5.setVisibility(8);
        } else if (i == 5) {
            relativeLayout2.setVisibility(8);
            relativeLayout.setVisibility(8);
            relativeLayout3.setVisibility(8);
            relativeLayout4.setVisibility(8);
            relativeLayout5.setVisibility(0);
        }
    }

    public static void removeItems(int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        if (i == 1) {
            linearLayout2.removeAllViews();
            linearLayout3.removeAllViews();
            linearLayout4.removeAllViews();
        } else if (i == 2) {
            linearLayout.removeAllViews();
            linearLayout3.removeAllViews();
            linearLayout4.removeAllViews();
        } else if (i == 3) {
            linearLayout2.removeAllViews();
            linearLayout.removeAllViews();
            linearLayout4.removeAllViews();
        } else if (i == 3) {
            linearLayout2.removeAllViews();
            linearLayout.removeAllViews();
            linearLayout3.removeAllViews();
        }
    }

    public static void manageMenuVisibility(int i, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3) {
        if (i == 1) {
            relativeLayout.setVisibility(0);
            relativeLayout2.setVisibility(8);
            relativeLayout3.setVisibility(8);
        } else if (i == 2) {
            relativeLayout.setVisibility(8);
            relativeLayout2.setVisibility(0);
            relativeLayout3.setVisibility(8);
        } else if (i == 3) {
            relativeLayout.setVisibility(8);
            relativeLayout2.setVisibility(0);
            relativeLayout3.setVisibility(8);
        } else if (i == 4) {
            relativeLayout.setVisibility(8);
            relativeLayout2.setVisibility(8);
            relativeLayout3.setVisibility(0);
        }
    }
}
