package com.mobile.yanxu.smarket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.List;


/**
 * Created by yanxu on 30/09/2014.
 */
public class ItemDetailsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        List<Item> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<Item> cart = ShoppingCartHelper.getCart();

        int ItemIndex = getIntent().getExtras().getInt(ShoppingCartHelper.Item_INDEX);
        final Item selectedItem = catalog.get(ItemIndex);

        // Set the proper image and text
        ImageView ItemImageView = (ImageView) findViewById(R.id.ImageViewItem);
        ItemImageView.setImageDrawable(selectedItem.itemImage);
        TextView ItemNameTextView = (TextView) findViewById(R.id.TextViewItemName);
        ItemNameTextView.setText(selectedItem.name);
        TextView ItemPriceTextView = (TextView) findViewById(R.id.TextViewItemPrice);
        ItemPriceTextView.setText(String.valueOf(selectedItem.price));
        TextView ItemDetailsTextView = (TextView) findViewById(R.id.TextViewItemDetails);
        ItemDetailsTextView.setText(selectedItem.description);

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
