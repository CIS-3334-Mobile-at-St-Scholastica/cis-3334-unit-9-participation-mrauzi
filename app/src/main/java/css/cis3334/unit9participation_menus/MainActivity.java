package css.cis3334.unit9participation_menus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import static css.cis3334.unit9participation_menus.R.id.imageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static final int CIS3334_IMAGE_CAPTURE = 1001;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //imageView object
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] addresses = {};
                String subject = "";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, addresses);
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);

        } else if (id == R.id.action_add) {
            //Add study mate
            Snackbar.make(getWindow().getDecorView(), "Adding study mates is not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();

        } else if (id == R.id.action_delete) {
            //Delete study mate
            Snackbar.make(getWindow().getDecorView(), "Deleting a study mate is not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();

        } else if (id == R.id.action_email) {
            //Send an email
            String[] addresses = {};
            String subject = "";
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else if (id == R.id.action_sms) {
            //Send an SMS
            String message = "";
            //Uri attachment;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
            intent.putExtra("sms_body", message);
            //intent.putExtra(Intent.EXTRA_STREAM, attachment);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (cameraIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(cameraIntent, CIS3334_IMAGE_CAPTURE);                 // CIS3334_IMAGE_CAPTURE declared as a constant above
            }
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);

        } else if (id == R.id.action_add) {
            //Add study mate
            Snackbar.make(getWindow().getDecorView(), "Adding study mates is not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();

        } else if (id == R.id.action_delete) {
            //Delete study mate
            Snackbar.make(getWindow().getDecorView(), "Deleting a study mate is not available yet.", Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();

        } else if (id == R.id.action_email) {
            //Send an email
            String[] addresses = {};
            String subject = "";
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        } else if (id == R.id.action_sms) {
            //Send an SMS
            String message = "";
            //Uri attachment;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"));  // This ensures only SMS apps respond
            intent.putExtra("sms_body", message);
            //intent.putExtra(Intent.EXTRA_STREAM, attachment);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    // process any data returned from the intents
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // get photo returned from camera
        if (requestCode == CIS3334_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Bitmap thumbnail = data.getParcelable("data");
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView2.setImageBitmap(photo);
        }
    }
}
