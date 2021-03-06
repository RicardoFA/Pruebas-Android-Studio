package com.example.android.sunshine.app;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastFragment extends Fragment {

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.forecastfragment, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_refresh) {
            FetchWeatherTask weatherTask = new FetchWeatherTask();
            weatherTask.execute("94043");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        String[] forecastArray = {
                "Hoy - Soleado - 88/33",
                "Mañana - Brumoso - 77/60",
                "Lunes - Lluvioso - 73/43",
                "Martes - Asteroides - 0/0",
                "Miercoles - Lluvia Pesada - 100/100",
                "Jueves - Soleado - 89/89",
                "viernes - Atrapado en el parque - 50/50",
                "Sabado - Nevado - 98/43",
                "Domingo - No se sabe 0/0?"
        };
        List<String> weekForecast = new ArrayList<String>(
                Arrays.asList(forecastArray));

        ArrayAdapter<String> mForecastAdapter =
                new ArrayAdapter<String>(
                        getActivity(),
                        //
                        R.layout.list_item_forecast,
                        //
                        R.id.list_item_forecast_textview,
                        //
                        weekForecast);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);

        return rootView;
    }
    public class FetchWeatherTask extends AsyncTask<String, Void, Void> {
        private final String LOG_TAG = FetchWeatherTask.class.getSimpleName();

        @Override
            protected Void doInBackground(String... params){
            if (params.length == 0){
                return null;
            }



                // These two need to be declared outside the try/catch
                // so that they can be closed in the finally block.
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;

                // Will contain the raw JSON response as a string.
                String forecastJsonStr = null;

            String format = "json";
            String units = "metric";
            int numDays = 7;

                try {

                    final String FORECAST_BASE_URL =
                            "http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7&APPID=7ad151d5841e9fa56a7d9db810874017";
                    final String QUERY_PARAM = "q";
                    final String FORMAT_PARAM = "mode";
                    final String UNITS_PARAM = "units";
                    final String DAYS_PARAM = "cnt";

                    Uri builtUri = Uri.parse(FORECAST_BASE_URL).buildUpon()
                            .appendQueryParameter(QUERY_PARAM, params[0])
                            .appendQueryParameter(FORMAT_PARAM, format)
                            .appendQueryParameter(UNITS_PARAM, units)
                            .appendQueryParameter(DAYS_PARAM, Integer.toString(numDays))
                            .build();

                    URL url = new URL (builtUri.toString());
                    Log.v(LOG_TAG, "Built URI" + builtUri.toString());

                    // Construct the URL for the OpenWeatherMap query
                    // Possible parameters are available at OWM's forecast API page, at
                    // http://openweathermap.org/API#forecast


                    // Create the request to OpenWeatherMap, and open the connection
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    // Read the input stream into a String
                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        return null;
                    }
                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                        // But it does make debugging a *lot* easier if you print out the completed
                        // buffer for debugging.
                        buffer.append(line + "\n");
                    }

                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        return null;
                    }
                    forecastJsonStr = buffer.toString();
                    Log.v(LOG_TAG, "Forecast JSON String: " +forecastJsonStr);
                } catch (IOException e) {
                    Log.e("ForecastFragment", "Error ", e);
                    // If the code didn't successfully get the weather data, there's no point in attempting
                    // to parse it.
                    return null;
                } finally{
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e("ForecastFragment", "Error closing stream", e);
                        }
                    }
                }

            return null;
        }
    }
}