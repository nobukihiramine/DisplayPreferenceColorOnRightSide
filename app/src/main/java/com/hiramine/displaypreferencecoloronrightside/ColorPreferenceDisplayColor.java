package com.hiramine.displaypreferencecoloronrightside;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ColorPreferenceDisplayColor extends ColorPreference
{
	public ColorPreferenceDisplayColor( Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes )
	{
		super( context, attrs, defStyleAttr, defStyleRes );
	}

	public ColorPreferenceDisplayColor( Context context, AttributeSet attrs, int defStyleAttr )
	{
		super( context, attrs, defStyleAttr );
	}

	public ColorPreferenceDisplayColor( Context context, AttributeSet attrs )
	{
		super( context, attrs );
	}

	public ColorPreferenceDisplayColor( Context context )
	{
		super( context );
	}

	@Override
	protected View onCreateView( ViewGroup parent )
	{
		setWidgetLayoutResource( R.layout.widget_coloredimage );
		return super.onCreateView( parent );
	}

	@Override
	protected void onBindView( View view )
	{
		super.onBindView( view );

		ImageView imageView = (ImageView)view.findViewById( R.id.imageview_color );
		imageView.setBackgroundColor( getColor() );
	}

	// プリファレンス変更結果を、呼び出し元の画面に反映されるために、notifyChanged() が必要。
	@Override
	public void setColor( int value )
	{
		super.setColor( value );

		notifyChanged();
	}
}
