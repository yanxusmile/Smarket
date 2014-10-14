package com.mobile.yanxu.smarket;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.util.List;


/**
 * Created by yanxu on 30/09/2014.
 */
public class ItemDetailsActivity extends Activity {

	private List<Item> mHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item_detail);

	    mHistoryList = LocalData.getHistoryLog();

        List<Item> catalog = LocalData.getCatalog(getResources());
        final List<Item> cart = LocalData.getCart();

        int ItemIndex = getIntent().getExtras().getInt(LocalData.Item_INDEX);
        final Item selectedItem = catalog.get(ItemIndex);

        // Set the proper image and text
        ImageView ItemImageView = (ImageView) findViewById(R.id.ImageViewItemDetail);
        ItemImageView.setImageDrawable(selectedItem.getDrawableImage());

        TextView ItemNameTextView = (TextView) findViewById(R.id.TextViewItemDetailName);
        ItemNameTextView.setText(selectedItem.getName());

        TextView ItemPriceTextView = (TextView) findViewById(R.id.TextViewItemDetailPrice);
        ItemPriceTextView.setText(String.valueOf(selectedItem.getPrice()));

        TextView ItemDetailsTextView = (TextView) findViewById(R.id.TextViewItemDetailsDescription);
        ItemDetailsTextView.setText(selectedItem.getDescription());

	    RatingBar ratingBarItem = (RatingBar) findViewById(R.id.ratingItemDetailBar);
	    // read rating
	    ratingBarItem.setRating(1.0f);


	    TextView ItemDetailComments = (TextView) findViewById(R.id.TextViewItemDetailsComments);
	    ItemDetailComments.setText(selectedItem.comments);
	    ItemDetailComments.setMovementMethod(new ScrollingMovementMethod());

	    final EditText myComment = (EditText) findViewById(R.id.TextViewItemDetailMyComment);


	    RatingBar ratingBarYours = (RatingBar) findViewById(R.id.ratingBarYours);
//	    float ratingScroe = 0;
	    // Set ChangeListener to Rating Bar
	    ratingBarYours.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
		    public void onRatingChanged(RatingBar ratingBar, float rating,
		                                boolean fromUser) {
//			    ratingScroe = rating;
			    Toast.makeText(getApplicationContext(), "Your Ratings  : " + String.valueOf(rating), Toast.LENGTH_LONG).show();
		    }
	    });

	    Button commentBtn = (Button) findViewById(R.id.btnItemDetailComment);
	    commentBtn.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View v) {
				if (mHistoryList.contains(selectedItem)) {
					String comment = myComment.getText().toString();
					selectedItem.comments += "\n" + comment;
					Toast.makeText(getApplicationContext(), "Successfully comment.", Toast.LENGTH_LONG).show();

				}
			    else {
					Toast.makeText(getApplicationContext(), "You can only comment it after you buy it.", Toast.LENGTH_LONG).show();
				}
//			    selectedItem.ratingScore = selectedItem.ratingScore +
//			    Toast.makeText(getApplicationContext(), "Your Comment  : " + comment , Toast.LENGTH_LONG).show();
		    }
	    });

	    Button addToCartButton = (Button) findViewById(R.id.btnAddToCart);
        addToCartButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                cart.add(selectedItem);
                finish();
            }
        });

        // Disable the add to cart button if the item is already in the cart
        if(cart.contains(selectedItem)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item in Cart");
        }
    }

}
