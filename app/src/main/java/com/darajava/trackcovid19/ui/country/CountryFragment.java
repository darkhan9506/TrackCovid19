package com.darajava.trackcovid19.ui.country;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
<<<<<<< HEAD
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
=======
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SearchView;
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.darajava.trackcovid19.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.

public class CountryFragment extends Fragment {

    RecyclerView rvCovidCountry;
    ProgressBar progressBar;
<<<<<<< HEAD
    TextView tvTotalCountry;

    private static final String TAG = CountryFragment.class.getSimpleName();
    ArrayList<CovidCountry> covidCountries;
=======
    CovidCountryAdapter covidCountryAdapter;

    private static final String TAG = CountryFragment.class.getSimpleName();
    List<CovidCountry> covidCountries;
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_country, container, false);

<<<<<<< HEAD
        // call view
        rvCovidCountry = root.findViewById(R.id.rvCovidCountry);
        tvTotalCountry = root.findViewById(R.id.tvTotalCountries);
=======
        // set Has option menu as true because we have menu
        setHasOptionsMenu(true);

        // call view
        rvCovidCountry = root.findViewById(R.id.rvCovidCountry);
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
        progressBar = root.findViewById(R.id.progress_circular_country);
        rvCovidCountry.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvCovidCountry.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line_divider));
        rvCovidCountry.addItemDecoration(dividerItemDecoration);

<<<<<<< HEAD
=======
        // call list
        covidCountries = new ArrayList<>();

>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
        // call Volley method
        getDataFromServer();

        return root;
    }

    private void showRecyclerView() {
<<<<<<< HEAD
        CovidCountryAdapter covidCountryAdapter = new CovidCountryAdapter(covidCountries, getActivity());
=======
        covidCountryAdapter = new CovidCountryAdapter(covidCountries, getActivity());
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
        rvCovidCountry.setAdapter(covidCountryAdapter);

        ItemClickSupport.addTo(rvCovidCountry).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedCovidCountry(covidCountries.get(position));
            }
        });
    }

    private void showSelectedCovidCountry(CovidCountry covidCountry) {
        Intent covidCountryDetail = new Intent(getActivity(), CovidCountryDetail.class);
        covidCountryDetail.putExtra("EXTRA_COVID", covidCountry);
        startActivity(covidCountryDetail);
    }

    private void getDataFromServer() {
        String url = "https://corona.lmao.ninja/countries";

<<<<<<< HEAD
        covidCountries = new ArrayList<>();
=======
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);

                if (response != null) {
                    Log.e(TAG, "onResponse: " + response);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

<<<<<<< HEAD
                            // Extract JSONPbject inside JSONObject
=======
                            // Extract JSONObject inside JSONObject
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
                            JSONObject countryInfo = data.getJSONObject("countryInfo");

                            covidCountries.add(new CovidCountry(data.getString("country"), data.getString("cases"),
                                    data.getString("todayCases"), data.getString("deaths"),
                                    data.getString("todayDeaths"), data.getString("recovered"),
                                    data.getString("active"), data.getString("critical"),
                                    countryInfo.getString("flag")));
                        }
<<<<<<< HEAD
                        tvTotalCountry.setText(jsonArray.length() + " countries");
=======

                        // Action Bar Title
                        getActivity().setTitle(jsonArray.length()+ " countries");

>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
                        showRecyclerView();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        Log.e(TAG, "onResponse: " + error);
                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }
<<<<<<< HEAD
=======

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = new SearchView(getActivity());
        searchView.setQueryHint("Search...");
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (covidCountryAdapter != null) {
                    covidCountryAdapter.getFilter().filter(newText);
                }
                return true;
            }
        });

        searchItem.setActionView(searchView);
        super.onCreateOptionsMenu(menu, inflater);
    }
>>>>>>> Adding Filter to Country in RecyclerView with SearchView.
}
