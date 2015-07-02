package ch.bbcag.todo.Fragments;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import ch.bbcag.todo.R;
import ch.bbcag.todo.Database.Aufgabe;
import ch.bbcag.todo.Database.AufgabenDAO;

/**
 * Created by zascho on 24.06.2015.
 */
public class AufgabeAnsicht_Fragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.aufgabe_layout, container, false);
        AufgabenDAO aufgabenDAO = new AufgabenDAO(getActivity());
        informationenSetzen(aufgabenDAO.getAllInformationForTask(getAufgabentitel()));
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

    public void informationenSetzen(Aufgabe aufgabe) {
        final TextView titel = (TextView) myView.findViewById(R.id.aufgabentitel);
        final TextView beschreibung = (TextView) myView.findViewById(R.id.detailAnsichtBeschreibung);
        final TextView wichtigkeit = (TextView) myView.findViewById(R.id.wichtigkeitText);

        final ImageView imgview = (ImageView) myView.findViewById(R.id.imageView);
        titel.setText(aufgabe.getAufgabe());
        beschreibung.setText(aufgabe.getBeschreibung());
     //   wichtigkeit.setText(wichtigkeitErmitteln(aufgabe.getWichtigkeit()));


        if(aufgabe.getBild_uri() != null){
            imgview.setImageURI(aufgabe.getBild_uri());


        } else {
            imgview.setImageResource(R.mipmap.todo);
        }




        CheckBox checkBox = (CheckBox) myView.findViewById(R.id.taskbeenden);
        checkBox.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            titel.setText("OK");
                                        }
                                    }
        );


    }
    private String getAufgabentitel() {
        Bundle bundle = this.getArguments();
        String listenname = bundle.getString("Aufgabe");
        return listenname;
    }

    private String wichtigkeitErmitteln(long wichtigkeitsID) {
        if (wichtigkeitsID == -1) {
            return "Wichtig";
        }
        if (wichtigkeitsID == 2131558502) {
            return "Normal";
        }
        if (wichtigkeitsID == 2131558503) {
            return "Unwichtig";
        } else {
            return "Sehr wichtig";
        }

    }
}
