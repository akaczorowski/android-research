package akaczorowski.pl.android.research;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import research.android.pl.akaczorowski.recyclerview_template.R;

public class PersonsAdapter
    extends RecyclerView.Adapter<PersonsAdapter.PersonViewHolder> {

  private List<Person> printers = new ArrayList<>();

  public void addPersons(List<Person> persons) {
    if (persons != null) {
      this.printers.addAll(persons);
      notifyItemRangeInserted(this.printers.size() - persons.size(), persons.size());
    }
  }

  public void addPerson(Person person) {
    if (printers != null) {
      this.printers.add(person);
      notifyItemRangeInserted(this.printers.size() - 1, 1);
    }
  }

  public void setPersons(List<Person> persons) {
    int printersCount = this.printers.size();
    this.printers.clear();
    if (persons != null) {
      this.printers.addAll(persons);
      notifyDataSetChanged();
    } else {
      notifyItemRangeRemoved(0, printersCount);
    }
  }

  public Person getItemData(int position) {
    return printers.get(position);
  }

  @Override
  public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext()).inflate(
        R.layout.row_persons_list, parent, false);

    PersonViewHolder viewHolder = new PersonViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(PersonViewHolder viewHolder, int position) {

    String name;
    String type = "";
    String address;
    final Person printer = printers.get(position);

    if (printer.isFriend) {
      type = "Friend";
    }
    name = printer.name;
    address = printer.address;

    viewHolder.name.setText(name);
    viewHolder.type.setText(type);
    viewHolder.address.setText(address);
  }

  @Override
  public int getItemCount() {
    return this.printers.size();
  }

  public class PersonViewHolder extends RecyclerView.ViewHolder {

    public TextView type;
    public TextView name;
    public TextView address;

    public PersonViewHolder(View itemView) {
      super(itemView);
      type = (TextView) itemView.findViewById(R.id.type);
      name = (TextView) itemView.findViewById(R.id.name);
      address = (TextView) itemView.findViewById(R.id.address);
    }
  }

}
