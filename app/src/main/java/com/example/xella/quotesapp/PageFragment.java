package com.example.xella.quotesapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.w3c.dom.Text;
import java.util.Random;

/**
 * Created by Xella on 19-Jun-17.
 */

public class PageFragment extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backgroundColor;

    String[] backgroundColorArray = {
        "0x222222", "0x666666", "0x000000"
    };

    static PageFragment newInstance(int page, String quoteText, String quoteAuthor) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        arguments.putString("Quotation Text", quoteText);
        arguments.putString("Quotation Author", quoteAuthor);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        int randomIndex = rnd.nextInt(backgroundColorArray.length - 1);
        Log.v("new bgcolor", backgroundColorArray[randomIndex]);
        //backgroundColor = Color.parseColor(backgroundColorArray[randomIndex]);
        //backgroundColor = Color.argb(60, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        TextView quoteTextView = (TextView) view.findViewById(R.id.quote_text);
        quoteTextView.setText(getArguments().getString("Quotation Text"));

        TextView quoteAuthorTextView = (TextView) view.findViewById(R.id.quote_author);
        quoteAuthorTextView.setText(getArguments().getString("Quotation Author"));

        LinearLayout quotePage = (LinearLayout) view.findViewById(R.id.quote_page);
        quotePage.setBackgroundColor(backgroundColor);

        return view;
    }
}
