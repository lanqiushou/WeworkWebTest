package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.ContactPage;
import page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestContact {
    static MainPage main;
    static ContactPage contact;
    @BeforeAll
    static void beforeAll(){
        main=new MainPage();
        contact=main.toContact();
    }

    @Test
    void testAddMember(){
        String username=contact.addMember("3", "3", "15600534763").search("3").getUserName();
        assertEquals(username, "3");
    }

    @Test
    void testSearch(){
        contact.search("3").delete();
    }

    @Test
    void testImportFromFile(){
        //todo: 中文名
        contact.importFromFile(this.getClass().getResource("/通讯录批量导入模板.xlsx"));

    }

    @Test
    void testAddDepartment() {
        contact.addDepartment("技术部");
    }

    @Test
    void testDeleteDepartment() {
        contact.deleteDepartment("技术部");
    }

    @Test
    void testAddTag() {
        String expectedTagName = "测试";
        String tagName = contact.addTag(expectedTagName).flush().search(expectedTagName).getTagName().trim();

//        assertEquals(expectedTagName,tagName);
    }

    @Test
    void testDeleteTag() {
        contact.deleteTag("测试");
    }

    @AfterAll
    static void afterAll(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        contact.quit();
    }

}
