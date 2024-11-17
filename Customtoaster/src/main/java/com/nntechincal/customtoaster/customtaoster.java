package com.nntechincal.customtoaster;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class customtaoster {


    public static void showCustomToast(
            Context context,
            String message,
            Integer backgroundColorResId,
            Integer textColorResId,
            Integer toastDuration,
            Integer gravity,
            Integer xOffset,
            Integer yOffset
    ) {
        Activity activity = (Activity) context;

        // Inflate custom toast layout
        LayoutInflater inflater = activity.getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout, null);

        // Set the message
        TextView text = layout.findViewById(R.id.toast_message);
        text.setText(message);

        // Default background and text colors
        int defaultBackgroundColor = resolveColor(context, android.R.color.black);
        int defaultTextColor = resolveColor(context, android.R.color.white);

        // Change the background color
        LinearLayout rootLayout = layout.findViewById(R.id.toast_root);
        Drawable backgroundDrawable = rootLayout.getBackground();
        if (backgroundDrawable instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) backgroundDrawable;
            int backgroundColor = (backgroundColorResId != null) ? resolveColor(context, backgroundColorResId) : defaultBackgroundColor;
            gradientDrawable.setColor(backgroundColor);
        }

        // Change the text color
        int textColor = (textColorResId != null) ? resolveColor(context, textColorResId) : defaultTextColor;
        text.setTextColor(textColor);

        // Set default values for optional parameters
        int duration = (toastDuration != null) ? toastDuration : Toast.LENGTH_SHORT;
        int toastGravity = (gravity != null) ? gravity : Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        int defaultXOffset = (xOffset != null) ? xOffset : 0;
        int defaultYOffset = (yOffset != null) ? yOffset : 500;

        // Create and configure the Toast object
        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setGravity(toastGravity, defaultXOffset, defaultYOffset);
        toast.setView(layout);

        //show the toast
        // Show the toast
        toast.show();
    }


    // Overloaded method for default values
    public static void showCustomToast(Context context, String message) {
        showCustomToast(context, message, null, null, null, null, null, null);
    }


    // Overloaded method for default values
    public static void showCustomToast(Context context, String message, Integer backgroundColorResId) {
        showCustomToast(context, message, backgroundColorResId, null, null, null, null, null);
    }

    private static int resolveColor(Context context, int colorResId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getResources().getColor(colorResId, null);
        } else {
            return context.getResources().getColor(colorResId);
        }
    }
}
