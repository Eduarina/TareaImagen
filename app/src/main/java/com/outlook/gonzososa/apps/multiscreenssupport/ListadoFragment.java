package com.outlook.gonzososa.apps.multiscreenssupport;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate (R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentActivity activity = getActivity ();
        if (activity == null) return;

        RecyclerView recyclerView = activity.findViewById (R.id.rvListado);
        if (recyclerView == null) return;

        ArrayList<String> names = new ArrayList<> ();
        String[] testArray = getResources().getStringArray(R.array.names);
        for (String e: testArray) {
            names.add(e);
        }

        ArrayList<Drawable> images = new ArrayList<>();
        TypedArray testInteger = getResources().obtainTypedArray(R.array.images);
        for (int i = 0; i < testInteger.length();i++){
            images.add(testInteger.getDrawable(i));
        }

        recyclerView.setLayoutManager (new GridLayoutManager(getContext (), 2));
        recyclerView.setAdapter (new  ListadoAdapter (getContext (), names, images));
    }
}

class ListadoAdapter extends RecyclerView.Adapter<ListadoViewHolder> {
    private Context context;
    private ArrayList<String> myData;
    private ArrayList<Drawable> imagen;

    ListadoAdapter (Context context, ArrayList<String> myData, ArrayList<Drawable> myImages) {
        this.context = context;
        this.myData = myData;
        this.imagen = myImages;
    }

    @NonNull
    @Override
    public ListadoViewHolder onCreateViewHolder (@NonNull ViewGroup viewGroup, int i) {
        View rowView = LayoutInflater.from (context).inflate (R.layout.listado_row, viewGroup, false);
        return new ListadoViewHolder (rowView);
    }

    @Override
    public void onBindViewHolder (@NonNull ListadoViewHolder listadoViewHolder, int i) {
        listadoViewHolder.bind (myData.get (i),imagen.get(i));
    }

    @Override
    public int getItemCount () {
        return myData.size ();
    }

}

class ListadoViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private ImageView imageView;

    ListadoViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.listadoItem);
        imageView = itemView.findViewById(R.id.imageItem);

    }

    public void bind(String text, Drawable dato) {
        textView.setText(text);
        imageView.setImageDrawable(dato);
    }

}
