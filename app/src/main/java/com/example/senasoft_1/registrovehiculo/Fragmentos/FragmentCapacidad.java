package com.example.senasoft_1.registrovehiculo.Fragmentos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.senasoft_1.registrovehiculo.Pojos.Pojos;
import com.example.senasoft_1.registrovehiculo.R;
import com.example.senasoft_1.registrovehiculo.Utils.Utils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentCapacidad.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentCapacidad#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCapacidad extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button btnGuardar;
    EditText mxCarros,mxMotos;
    SharedPreferences preferencesOne,preferencesTwo;
    Intent intent;
    Pojos pojos;
    int mxAutos,mxMoto;

    public FragmentCapacidad() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentCapacidad.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCapacidad newInstance(int param1) {
        FragmentCapacidad fragment = new FragmentCapacidad();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_capacidad, container, false);
        addIds(view);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*SharedPreferences preferencesOne= getContext().getSharedPreferences("mxCarros",Context.MODE_PRIVATE);
                SharedPreferences.Editor editorOne=preferencesOne.edit();
                editorOne.putString(String.valueOf(Utils.NUMMXAUTOS),mxCarros.getText().toString());
                editorOne.commit();

                SharedPreferences preferencesTwo= getContext().getSharedPreferences("mxMotos",Context.MODE_PRIVATE);
                SharedPreferences.Editor editorTwo=preferencesTwo.edit();
                editorTwo.putString(String.valueOf(Utils.NUMMXMOTOS),mxMotos.getText().toString());
                editorTwo.commit();*/

                pojos=new Pojos(mxCarros.getText().toString(),mxMotos.getText().toString());
                mListener.onFragmentInteraction(pojos);

            }

        });

        return view;
    }

    public void addIds(View view){
        btnGuardar=view.findViewById(R.id.btnGuardar);
        mxCarros=view.findViewById(R.id.cantidadCarros);
        mxMotos=view.findViewById(R.id.cantidadMotos);
    }

    public void addFrag(Fragment fragment){
        FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framehome,fragment);
        transaction.commit();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            //mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Pojos pojos);
    }
}
