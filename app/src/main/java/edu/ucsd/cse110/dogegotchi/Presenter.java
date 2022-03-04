package edu.ucsd.cse110.dogegotchi;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import edu.ucsd.cse110.dogegotchi.doge.Doge;
import edu.ucsd.cse110.dogegotchi.doge.IDogeObserver;

public class Presenter implements IDogeObserver
{
    Doge doge;
    Activity activity;
    View foodMenu;
    ImageButton hamButton;
    ImageButton steakButton;
    ImageButton turkeyLegButton;

    public Presenter(Doge doge, Activity activity)
    {
        this.doge = doge;
        this.activity = activity;
        doge.register(this);
        foodMenu = activity.findViewById(R.id.FoodMenuView);
        hamButton = foodMenu.findViewById(R.id.HamButton);
        steakButton = foodMenu.findViewById(R.id.SteakButton);
        turkeyLegButton = foodMenu.findViewById(R.id.TurkeyLegButton);
        hamButton.setOnClickListener((View v) -> {
            eat();
        });
        steakButton.setOnClickListener((View v) -> {
            eat();
        });
        turkeyLegButton.setOnClickListener((View v) -> {
            eat();
        });
    }

    public void eat()
    {
        doge.eat();
    }

    public void onStateChange(Doge.State newState)
    {
        if(newState.equals(Doge.State.SAD))
        {
            makeMenuVisible();
        }
        else
        {
            makeMenuInvisible();
        }
    }

    private void makeMenuVisible()
    {
        foodMenu.setVisibility(View.VISIBLE);
    }

    private void makeMenuInvisible()
    {
        foodMenu.setVisibility(View.GONE);
    }
}
