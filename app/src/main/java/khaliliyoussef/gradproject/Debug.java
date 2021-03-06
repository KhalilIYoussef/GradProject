package khaliliyoussef.gradproject;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.DumperPluginsProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.dumpapp.DumperPlugin;

import java.util.ArrayList;

/**
 * Created by Khalil on 6/5/2017.
 */

public class Debug extends Application
{

    @Override
    public void onCreate() {
        super.onCreate();
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

// Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

// Enable command line interface
        Context context = this;
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(context)
        );

// Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

// Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }
}
    //
//    private class SampleDumpperPluginProvider implements DumperPluginsProvider {
//            private Context mContext ;
//
//        public SampleDumpperPluginProvider(Context context) {
//            mContext=context;
//        }
//
//        @Override
//        public Iterable<DumperPlugin> get() {
//            ArrayList<DumperPlugin> plugins = new ArrayList<>();
//            for(DumperPlugin defaultPlugin:Stetho.defaultDumperPluginsProvider(mContext).get())
//            {
//                plugins.add(defaultPlugin);
//            }
//            plugins.add(new MyDebugPlugin());
//            return plugins;
//        }
//    }


