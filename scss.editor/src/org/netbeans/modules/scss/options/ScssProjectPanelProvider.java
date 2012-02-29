package org.netbeans.modules.scss.options;

import java.util.ResourceBundle;
import javax.swing.JPanel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import org.netbeans.spi.project.ui.support.ProjectCustomizer.Category;
import org.openide.util.Lookup;
import org.openide.util.NbBundle;

public class ScssProjectPanelProvider implements ProjectCustomizer.CompositeCategoryProvider {

	private static final String SCSS = "ScssProject";

	@ProjectCustomizer.CompositeCategoryProvider.Registration(projectType = "org-netbeans-modules-php-project")
	public static ScssProjectPanelProvider createScss() {
		return new ScssProjectPanelProvider(SCSS);
	}

	private String name;

	private ScssProjectPanelProvider(String name) {
		this.name = name;
	}

	@Override
	public Category createCategory(Lookup lkp) {
		ResourceBundle bundle = NbBundle.getBundle(ScssProjectPanelProvider.class);
		return ProjectCustomizer.Category.create(SCSS,bundle.getString("ScssProjectPanel.config"),null);
	}

	@Override
	public JPanel createComponent(Category category, Lookup lkp) {
		return new ScssProjectPanel(new ScssProjectOptionsPanelController());
	}
}