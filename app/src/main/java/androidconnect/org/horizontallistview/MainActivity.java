package androidconnect.org.horizontallistview;

import android.content.Context;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import androidconnect.org.horizontallistview.adapter.HorizontalAdapter;
import androidconnect.org.horizontallistview.model.ViewModel;
import androidconnect.org.horizontallistview.ui.HorizontalListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements AdapterView.OnItemClickListener {

        private ArrayList<ViewModel> listModels;
        private HorizontalAdapter adapter;
        private HorizontalListView rootView;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            rootView = (HorizontalListView) inflater.inflate(R.layout.fragment_main, container, false);

            //Generate data
            listModels = new ArrayList<ViewModel>();
            listModels.add( build() );
            listModels.add( build() );

            adapter = new HorizontalAdapter(getActivity().getApplicationContext(), listModels);
            rootView.setAdapter( adapter);
            rootView.setOnItemClickListener( this );
            return rootView;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            listModels.add( build() );
            adapter.setDataObjects(listModels);
            adapter.notifyDataSetChanged();

            Toast.makeText(getActivity().getApplicationContext(), "Mas gatos", Toast.LENGTH_SHORT).show();
        }

        private ViewModel build(){
            ViewModel model = new ViewModel();

            Random rand = new Random(Calendar.getInstance(Locale.ENGLISH).getTimeInMillis());
            if(rand.nextInt(2) ==1){
                model.setImage( R.drawable.cat2);
                model.setText( "dos gatos");
            }else{
                model.setImage( R.drawable.cat1);
                model.setText( "un gato");
            }
            return model;
        }

    }
}
