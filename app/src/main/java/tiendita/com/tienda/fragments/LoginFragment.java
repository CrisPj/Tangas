package tiendita.com.tienda.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import tiendita.com.tienda.R;
import tiendita.com.tienda.entities.UserData;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";
    private String url = "https://tangaweb-cresh.rhcloud.com/auth_users.php";

    private OnFragmentInteractionListener mListener;
    private RequestQueue tarea;
    private String session;
    private TextView txtUser;
    private TextView txtPass;

    private View mProgressView;
    private View mLoginFormView;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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
         mLoginFormView = (View) view.findViewById(R.id.login_form);
        mProgressView = view.findViewById(R.id.login_progress);
        upButton.setOnClickListener(this);
        return view;
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

        txtUser.setError(null);
        txtPass.setError(null);

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(pass) && !isPasswordValid(pass)) {
            txtPass.setError(getString(R.string.error_invalid_password));
            focusView = txtPass;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(user)) {
            txtUser.setError(getString(R.string.error_field_required));
            focusView = txtUser;
            cancel = true;
        }
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //todo check
                            Gson gson = new Gson();
                            UserData user = gson.fromJson(response, UserData.class);
                            if(Objects.equals(user.getValido(), "true")){
                                openProfile(response);
                                Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
                            }else{
                                //error
                                showProgress(false);
                                //mUserText.setError(getString(R.string.error_field_required));
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG ).show();
                        }
                    }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> map = new HashMap<String,String>();
                    map.put(KEY_USERNAME,user);
                    map.put(KEY_PASSWORD,pass);
                    return map;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
            requestQueue.add(stringRequest);
        }
    }

    private void openProfile(String response)
    {
        Gson gson = new Gson();
        UserData user = gson.fromJson(response,UserData.class);
        if (user.getRol().equals("adminstrador"))
        {
            //administrador
        }
        else
        {
            //usernormal
        }
    }


    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

        public interface OnFragmentInteractionListener {
            // TODO: Update argument type and name
            void onFragmentInteraction(Uri uri);
        }
    }
