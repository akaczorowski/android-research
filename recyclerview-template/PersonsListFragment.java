package akaczorowski.pl.android.research;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import research.android.pl.akaczorowski.recyclerview_template.R;

public class PersonsListFragment extends Fragment
    implements
    RecyclerViewItemClickSupport.OnItemClickListener,
    RecyclerViewItemClickSupport.OnItemLongClickListener {


  protected RecyclerView personsList;
  private OnListItemClickListener listItemClickListener;
  private PersonsAdapter personsAdapter;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    personsAdapter = new PersonsAdapter();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    final View rootView = inflater.inflate(R.layout.fragment_persons_list, container, false);
    personsList = (RecyclerView) rootView.findViewById(
        R.id.friendsList);
    personsList.setAdapter(personsAdapter);
    personsList.setLayoutManager(new LinearLayoutManager(getContext()));
    personsList.setItemAnimator(new SlideItemAnimator());
    RecyclerViewItemClickSupport.addTo(personsList).setOnItemClickListener(this)
                                .setOnItemLongClickListener(this);

    return rootView;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
      public void run() {
        addPersonsToList();
      }
    }, 1000l);

  }


  @Override
  public void onItemClicked(RecyclerView recyclerView, int position, View v) {
    final Person person = personsAdapter.getItemData(position);
  }

  @Override
  public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {
    // it importan to get this callback and return false, then list items selector (pressed, clicked etc.) will work
    return false;
  }

  private void addPersonsToList() {

    Person p1 = new Person();
    p1.address = "Cieczyn, ul. Zwojnicka 7";
    p1.isFriend = true;
    p1.name = "John Kowalski";

    Person p2 = new Person();
    p2.address = "Mieszkowo, aleja Hanny 6";
    p2.isFriend = true;
    p2.name = "Joanna True";

    List<Person> persons = new ArrayList<>();
    persons.add(p1);
    persons.add(p2);

    personsAdapter.addPersons(persons);

  }

  public interface OnListItemClickListener {
    void onListItemClicked(Person person);
  }
}
