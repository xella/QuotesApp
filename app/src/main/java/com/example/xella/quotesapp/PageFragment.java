package com.example.xella.quotesapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Xella on 19-Jun-17.
 */

public class PageFragment extends Fragment {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    int backgroundColor;

    static PageFragment newInstance(int page, String quoteText, String quoteAuthor, String color) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        arguments.putString("Quotation Text", quoteText);
        arguments.putString("Quotation Author", quoteAuthor);
        arguments.putString("Color", color);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        backgroundColor = Color.parseColor(getArguments().getString("Color"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        final String quoteText = getArguments().getString("Quotation Text");
        final String quoteAuthor = getArguments().getString("Quotation Author");

        TextView quoteTextView = (TextView) view.findViewById(R.id.quote_text);
        quoteTextView.setText(quoteText);

        TextView quoteAuthorTextView = (TextView) view.findViewById(R.id.quote_author);
        quoteAuthorTextView.setText(quoteAuthor);

        LinearLayout quotePage = (LinearLayout) view.findViewById(R.id.quote_page);
        quotePage.setBackgroundColor(backgroundColor);

        ImageButton shareButton = (ImageButton) view.findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(android.content.Intent.EXTRA_TEXT, quoteText + " \n" + "Written by " + quoteAuthor);
                startActivity(intent);
            }
        });

        return view;
    }
}


