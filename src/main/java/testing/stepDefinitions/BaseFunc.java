package testing.stepDefinitions;

import gherkin.lexer.Da;
import testing.modals.UserMenu;
import testing.pages.*;

public abstract class BaseFunc {


    protected LoginPage loginPage = new LoginPage();
    protected AnalysisPage analysisPage = new AnalysisPage();
    protected BatteriePage batteriePage = new BatteriePage();
    protected CommunityPage communityPage = new CommunityPage();
    protected DashboardPage dashboardPage = new DashboardPage();
    protected DemoModePage demoModePage = new DemoModePage();
    protected FlatPage flatPage = new FlatPage();
    protected LandingPage landingPage = new LandingPage();
    protected LiveStatePage liveStatePage = new LiveStatePage();
    protected  OnboardingConfirmationPage onboardingConfirmationPage
            = new OnboardingConfirmationPage();
    protected RegistrationStep1Page registrationStep1Page = new RegistrationStep1Page();
    protected RegistrationStep2Page registrationStep2Page = new RegistrationStep2Page();
    protected UserMenu userMenu = new UserMenu();
}
