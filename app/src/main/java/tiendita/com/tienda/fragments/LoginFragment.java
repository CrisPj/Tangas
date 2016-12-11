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

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import tiendita.com.tienda.R;
import tiendita.com.tienda.api.LoginAPI;
import tiendita.com.tienda.api.ServiceGenerator;
import tiendita.com.tienda.entities.UserData;

public class LoginFragment extends Fragment implements View.OnClickListener {

    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    private OnFragmentInteractionListener mListener;
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
         mLoginFormView = (View) view.findViewById(R.id.login_form);
        mProgressView = view.findViewById(R.id.login_progress);
        upButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
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
            focusView.requestFocus();
        } else {
            showProgress(true);

            LoginAPI login = ServiceGenerator.createAuthenticatedService(LoginAPI.class,getContext());
            HashMap<String,String> params = new HashMap<String,String>();
                                params.put(KEY_USERNAME,user);
                                params.put(KEY_PASSWORD,pass);
            login.login(params).enqueue(new Callback<UserData>() {
                @Override
                public void onResponse(Call<UserData> call, retrofit2.Response<UserData> response) {
                    //todo check
                    UserData user = response.body();
                    if (Objects.equals(user.getValido(), "true")) {
                        openProfile(user);
                    } else {
                        //error
                        showProgress(false);
                        Toast.makeText(getContext(),"Usuario ó password incorrectos",Toast.LENGTH_LONG).show();
                        //mUserText.setError(getString(R.string.error_field_required));
                    }
                }

                @Override
                public void onFailure(Call<UserData> call, Throwable t) {

                }
            });
        }
    }

    private void openProfile(UserData user)
    {
        String rol = user.getRol();
        if (rol.equals("administrador"))
        {
            //administrador
            Toast.makeText(getContext(),"Eres admin",Toast.LENGTH_LONG).show();
        }
        else
        {
            //usernormal
            Toast.makeText(getContext(),"Eres un user silvestre",Toast.LENGTH_LONG).show();
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
