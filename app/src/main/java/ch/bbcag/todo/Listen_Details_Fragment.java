package ch.bbcag.todo;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import ch.bbcag.todo.database.Aufgabe;

/**
 * Created by zascho on 17.06.2015.
 */
public class Listen_Details_Fragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.listen_details_layout, container, false);
        addAufgabetolist();

        return myView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.plus_aufgabe, menu);
    }

    private void addAufgabetolist() {


        ListView list = (ListView) myView.findViewById(R.id.listView);
        ArrayList<Aufgabe> aufgabe = new ArrayList<Aufgabe>();
        Aufgabe test = new Aufgabe();
        test.setAufgabe("hello");
        aufgabe.add(test);
        list.setAdapter(new Ownarrayadapter(this.getActivity().getApplicationContext(), aufgabe, this.getActivity().getLayoutInflater()));
    }
}
