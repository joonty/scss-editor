package org.netbeans.modules.scss.options;

import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;

public class ScssProjectSettings {

    private static ScssProjectSettings scssSettings = null;
    private static final String PROP_OUTPUT_PATH = "outputPath";
    private static final long serialVersionUID = 85176380568174L;
    private Preferences prefs = null;
    private Project proj;

    private ScssProjectSettings() {
	    prefs = ProjectUtils.getPreferences(proj,ScssProjectSettings.class,true);
    }

    public static synchronized ScssProjectSettings getDefault(Project project) {
	if (scssSettings == null) {
	    scssSettings = new ScssProjectSettings();
	}
	return scssSettings;
    }

    public String getOutputPath() {
	return prefs.get(PROP_OUTPUT_PATH, null);
    }

    public final void setOutputPath(String path) {
	prefs.put(PROP_OUTPUT_PATH, path);
    }
}
