package androidconnect.org.horizontallistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidconnect.org.horizontallistview.R;
import androidconnect.org.horizontallistview.model.ViewModel;

/**
 * Created by lempere on 2/17/2015.
 */
public class HorizontalAdapter  extends BaseAdapter{

    private List<ViewModel> dataObjects;
    private Context ctx;

    public HorizontalAdapter(Context context){
        super();
        ctx = context;
    }

    public HorizontalAdapter(Context context, List<ViewModel> dataObjects) {
        this.dataObjects = dataObjects;
        ctx = context;
    }

    public void setDataObjects(List<ViewModel> dataObjects) {
        this.dataObjects = dataObjects;
    }

    public int getCount() {
        if(dataObjects==null) return 0;
        return dataObjects.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewModel model = dataObjects.get(position);
        final View horizontal_view = LayoutInflater.from(ctx).inflate(R.layout.view_item, parent, false);
        final TextView title = (TextView) horizontal_view.findViewById(R.id.title);
        final ImageView image = (ImageView) horizontal_view.findViewById(R.id.image);


        title.setText(model.getText());
        image.setImageResource(model.getImage());

        return horizontal_view;
    }

}
