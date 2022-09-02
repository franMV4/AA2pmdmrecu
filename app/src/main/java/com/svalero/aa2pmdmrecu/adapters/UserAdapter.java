package com.svalero.aa2pmdmrecu.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.svalero.aa2pmdmrecu.R;
import com.svalero.aa2pmdmrecu.domain.User;
import com.svalero.aa2pmdmrecu.util.ImageUtils;

import java.util.Base64;
import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private List<User> userArrayList;
    private LayoutInflater inflater;

    public UserAdapter(Activity context, List<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = (User) getItem(position);

        convertView = inflater.inflate(R.layout.user_and_car_adapter, null);
        ImageView userImage = (ImageView) convertView.findViewById(R.id.user_car_item_imageView);
        TextView userNameAndSurnameTv = convertView.findViewById(R.id.user_car_tv1);
        TextView userDniTv = convertView.findViewById(R.id.user_car_tv2);

        if (user.getUserImage() != null) {  // Valido si no es null la foto, si no sale fallo nullpoint...
            byte[] decode = Base64.getDecoder().decode(user.getUserImage());
            Log.i("userr",  Base64.getEncoder().encodeToString(decode));
            userImage.setImageBitmap(ImageUtils.getBitmap(decode));
            //userImage.setImageBitmap(ImageUtils.getBitmap(user.getUserImage()));
        } else {
            userImage.setImageResource(R.drawable.user_default);
        }
        userNameAndSurnameTv.setText(user.getName() + " " + user.getSurname());
        userDniTv.setText(user.getDni());

        return convertView;
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
