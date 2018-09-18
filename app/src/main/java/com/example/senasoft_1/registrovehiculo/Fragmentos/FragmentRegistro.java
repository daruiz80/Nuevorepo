package com.example.senasoft_1.registrovehiculo.Fragmentos;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.senasoft_1.registrovehiculo.R;
import com.example.senasoft_1.registrovehiculo.Utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentRegistro.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentRegistro#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRegistro extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    String cantiCarros,cantiMotos,items;
    Button btnRegistrar;
    TextView numCarrosDis,numMotosDis,sitiosDisCar,sitiosDisMot;
    RadioGroup radioGroup;
    RadioButton entrada,salida;
    int contadorSuma,contadorResta=30,radioButton;
    Spinner tipoVehiculo;
    public FragmentRegistro() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentRegistro.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRegistro newInstance(int param1) {
        FragmentRegistro fragment = new FragmentRegistro();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_registro, container, false);
        addIds(view);

        radioGroup();

        tipoVehiculo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                items=tipoVehiculo.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getActivity().getSharedPreferences("cuentamx",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString(String.valueOf(Utils.ITEMS),String.valueOf(items));
                editor.commit();

                SharedPreferences preferencesTwo=getActivity().getSharedPreferences("retardo",Context.MODE_PRIVATE);
                SharedPreferences.Editor editorTwo=preferencesTwo.edit();
                editorTwo.putString(String.valueOf(Utils.TIPOVEHICULO),String.valueOf(radioGroup()));
                editorTwo.commit();
                if (radioButton==1 && items.equals("carro")){
                    contadorSuma++;
                    numCarrosDis.setText("Numero de Carros: "+contadorSuma);
                    contadorResta--;
                    sitiosDisCar.setText("Sitios disponibles: "+contadorResta);

                }
            }
        });

        return view;
    }

    public void addIds(View view){
        btnRegistrar=view.findViewById(R.id.btnRegistrar);
        numCarrosDis=view.findViewById(R.id.numCarrosDis);
        numMotosDis=view.findViewById(R.id.numMotosDis);
        sitiosDisCar=view.findViewById(R.id.sitiosDisCar);
        sitiosDisMot=view.findViewById(R.id.sitiosDisMot);
        radioGroup=view.findViewById(R.id.radioGroup);
        entrada=view.findViewById(R.id.entrada);
        salida=view.findViewById(R.id.salida);
        tipoVehiculo=view.findViewById(R.id.tipoVehiculo);
    }

    public int radioGroup(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.entrada:
                        radioButton=1;
                        break;

                    case R.id.salida:
                        radioButton=2;
                        break;
                }
            }
        });
        return radioButton;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
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
        void onFragmentInteraction(Uri uri);
    }
}
