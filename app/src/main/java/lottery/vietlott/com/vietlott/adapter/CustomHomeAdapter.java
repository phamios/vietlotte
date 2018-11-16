package lottery.vietlott.com.vietlott.adapter;

/**
 * Created by macos on 11/12/18.
 */

import lottery.vietlott.com.vietlott.R;
import lottery.vietlott.com.vietlott.activity.AboutUsActivity;
import lottery.vietlott.com.vietlott.activity.PowerActivity;
import lottery.vietlott.com.vietlott.fragment.HomeFragment;
import lottery.vietlott.com.vietlott.fragment.MoviesFragment;
import lottery.vietlott.com.vietlott.ulti.AppController;
import lottery.vietlott.com.vietlott.model.Movie;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


public class CustomHomeAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Movie> movieItems;
    private Context mContext;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomHomeAdapter(Context context, Activity activity, List<Movie> movieItems) {
        this.activity = activity;
        this.mContext = context;
        this.movieItems = movieItems;
    }

    @Override
    public int getCount() {
        return movieItems.size();
    }

    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_row, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();
        NetworkImageView thumbNail = (NetworkImageView) convertView
                .findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView rating = (TextView) convertView.findViewById(R.id.rating);
        TextView genre = (TextView) convertView.findViewById(R.id.genre);
        TextView year = (TextView) convertView.findViewById(R.id.releaseYear);

        // getting movie data for the row
        Movie m = movieItems.get(position);

        // thumbnail image
        thumbNail.setImageUrl(m.getThumbnailUrl(), imageLoader);

        // title
        title.setText(m.getTitle());

        // rating
        rating.setText("Ngày quay: " + String.valueOf(m.getRating()));

        // genre
        String genreStr = "";
        for (String str : m.getGenre()) {
            genreStr += str + ", ";
        }
        genreStr = genreStr.length() > 0 ? genreStr.substring(0,
                genreStr.length() - 2) : genreStr;
        genre.setText(genreStr);

        // release year
        year.setText(String.valueOf(m.getYear()));

        View.OnClickListener yourClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(mContext,   "Hello" + position, Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity, PowerActivity.class));

//                MoviesFragment fragment2 = new MoviesFragment();
//                FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame,fragment2);
//                fragmentTransaction.commit();
            }
        };

        convertView.setOnClickListener(yourClickListener);


        return convertView;
    }

}