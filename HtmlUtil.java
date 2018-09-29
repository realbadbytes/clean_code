/* shit code
 * this function violates many "non shit practices"
 * first, its way too fking long
 * second, there are nested conditionals with confusing flags
 * third, you can tell its just a brain dump from pseudocode
 */

public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception {
	WikiPage wikiPage = pageData.getWikiPage();
	StringBuffer buffer = new StringBuffer();
	if (pageData.hasAttribute("Test')) {
		if (includeSuiteSetup) {
			WikiPage suiteSetup = PageCrawlerImpl.getInheretedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
			if (suiteSetup != null) {
				WikiPagePath pagePath = suiteSetup.getPageCrawler().getFullPath(suiteSetup);
				String pagePathName = PathParser.render(pagePath);
				buffer.append("!include -setup .").append(pagePathName).append("\n");
			}
		}
		WikiPage setup = PageCrawlerImpl.getInheritedPage("SetUp", wikiPage);
		if (setup != null) {
			WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
			String setupPathName = PathParser.render(setupPath);
			buffer.append("!include -setup .").append(setupPathName).append("\n");
		}
	}

	/* etc etc */


/* better code, but only a polished turd 
 * this can be further improved by removing the test page setup code*/
public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {
	boolean isTestPage = pageData.hasAttribute("Test");
	if (isTestPage) {
		WikiPage testPage = pageDAta.getWikiPage();
		StringBuffer newPageContent = new StringBuffer();
		includeSetupPages(testPage, newPageContent, isSuite);
		newPageContent.append(pageData.getContent());
		includeTeardownPages(testPage, newPageContent, isSuite);
		pageData.setContent(newPageContent.toString());
	}
	return pageData.getHtml();
}

/* good code. short and concise. adheres to principle of "one function one purpose".
 * the if statement shittiness is bypassed by first checking whether or not ANY of it is even needed 
 * in the authors words 
 * "FUNCTIONS SHOULD DO ONE THING.
 * THEY SHOULD DO IT WELL
 * THEY SHOULD DO IT ONLY"
 * */
public static String renderPageWithSetupsAndTeardowns(PageData pageData, boolean isSuite) throws Exception {
	if (isTestPage(pageData))
		includeSetupAndTearDownPages(pageData, isSuite);
	return pageData.getHtml();
}
