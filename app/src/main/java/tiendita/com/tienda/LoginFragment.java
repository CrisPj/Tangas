package tiendita.com.tienda;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener<String> {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String url = "https://tangaweb-cresh.rhcloud.com/auth_users.php";

    private OnFragmentInteractionListener mListener;
    private ProgressDialog progressDialog;
    private RequestQueue tarea;
    private String session;
    private TextView txtUser;
    private TextView txtPass;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button upButton = (Button) view.findViewById(R.id.email_sign_in_button);
        txtUser = (TextView) view.findViewById(R.id.user);
        txtPass = (TextView) view.findViewById(R.id.password);
        tarea = Volley.newRequestQueue(this.getContext());
        progressDialog = new ProgressDialog(this.getContext());
        progressDialog.setMessage("Cargando");
        upButton.setOnClickListener(this);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onClick(View view) {
        String user = txtUser.getText().toString();
        String pass = txtPass.getText().toString();
        login(user, pass);
    }

    //Hace petecion del login
    private void login(final String user, final String pass) {
        progressDialog.show();
        StringRequest login = new StringRequest(Request.Method.POST, url, this, this) {
            //Se envian los datos necesarios para la peticion
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                //Parametros en la peticion
                params.put("username", user);
                params.put("password", pass);
                return params;
            }
        };
        tarea.add(login);
        tarea.start();
    }

    @Override
    public void onErrorResponse(VolleyError volleyError) {
        String message = "";
        if (volleyError instanceof NetworkError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ServerError) {
            message = "The server could not be found. Please try again after some time!!";
        } else if (volleyError instanceof AuthFailureError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof ParseError) {
            message = "Parsing error! Please try again after some time!!";
        } else if (volleyError instanceof NoConnectionError) {
            message = "Cannot connect to Internet...Please check your connection!";
        } else if (volleyError instanceof TimeoutError) {
            message = "Connection TimeOut! Please check your internet connection.";
        }
        progressDialog.hide();
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(String response) {
        session = response;
        progressDialog.hide();
        auth();
    }

    public void auth() {
        try {
            JSONObject json = new JSONObject(session);
            if (json != null)
            {
                boolean b = false;

                    b = json.getBoolean("valido");
                    int id = json.getInt("id");
                    String rol = json.getString("rol");

                if (b) {

                    //Checo que tipo de usuario es, dependiendo de este se envia a su respectiva pantalla
                    if (rol.equalsIgnoreCase("administrator")) {
//                                                Intent i = new Intent(this, AdminActivity.class);
//                                                i.putExtra("id", id);
//                                                startActivity(i);
//
//                                                    } else {
//
//                                                    }
                    }
                    } else
                        Toast.makeText(getContext(), "Usuario o contrasenia incorrectos", Toast.LENGTH_SHORT).show();
                }


            else
                    Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        }
        public interface OnFragmentInteractionListener {
            // TODO: Update argument type and name
            void onFragmentInteraction(Uri uri);
        }
    }
