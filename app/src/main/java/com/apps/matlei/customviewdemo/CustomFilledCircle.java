package com.apps.matlei.customviewdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author lei <matleivs@gmail.com>
 */
public class CustomFilledCircle extends View {

    private boolean showNumber;
    private int numberFillRange;
    private int colorFill;
    private int colorStroke;

    public CustomFilledCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attributeSet, R.styleable.CustomFilledCircle, 0, 0);

            /* When a view is created from an XML layout, all of the attributes in the XML tag are read from the resource bundle and passed into the view's constructor as an AttributeSet.
            Although it's possible to read values from the AttributeSet directly, doing so has some disadvantages.
            So Instead, pass the AttributeSet to obtainStyledAttributes().
            This method passes back a TypedArray array of values that have already been dereferenced and styled.
            */
        try {
            showNumber = typedArray.getBoolean(R.styleable.CustomFilledCircle_showNumber, true);
            numberFillRange = typedArray.getInt(R.styleable.CustomFilledCircle_numberFillRange, 0);
            colorFill = typedArray.getColor(R.styleable.CustomFilledCircle_colorFill, Color.BLUE);
            colorStroke = typedArray.getColor(R.styleable.CustomFilledCircle_colorStroke, Color.BLACK);
        } finally {
                /* ! Note that TypedArray objects are a shared resource and must be recycled after use. */
            typedArray.recycle();
        }
    }

    /**
     * Notice: calls invalidate() and requestLayout() to ensure that the view behaves reliably.
     * You have to invalidate the view after any change to its properties that might change its appearance -> system knows it needs to be redrawn.
     * Likewise, you need to request a new layout if a property changes that might affect the size or shape of the view.
     *
     * @param numberFillRange
     */
    public void setNumberFillRange(int numberFillRange) {
        this.numberFillRange = numberFillRange;
        invalidate();
        requestLayout();
    }

}


