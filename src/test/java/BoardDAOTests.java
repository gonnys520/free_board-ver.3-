import org.gonnys.dao.BoardDAO;
import org.gonnys.domain.BoardVO;
import org.gonnys.domain.PageDTO;
import org.gonnys.domain.PageMaker;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class BoardDAOTests {

    private BoardDAO boardDAO = new BoardDAO();


    @Test
    public void testRead()throws Exception{
        int bno = 5701662;

        System.out.println(boardDAO.getBoard(bno,true));
    }


    @Test
    public void testPageMaker(){

        PageDTO dto = PageDTO.of().setPage(7).setSize(10);
        int total = 123;

        PageMaker pageMaker = new PageMaker(total, dto);
        System.out.println(pageMaker);

    }

    @Test
    public void testList()throws Exception{

        boardDAO.getList(PageDTO.of().setPage(2).setSize(100))
                .forEach(vo -> System.out.println(vo));

    }


    @Test
    public void testInsert() throws Exception{
        BoardVO vo = new BoardVO();
        vo.setTitle("머쓱...");
        vo.setContent("나만 안돼");
        vo.setWriter("gonnys");
        boardDAO.create(vo);
    }

    @Test
    public void test1() {
        assertNotNull(boardDAO);
        System.out.println("test1..............");

        PageDTO pageDTO = PageDTO.of().setSize(20).setPage(5);
        System.out.println(pageDTO);
    }



}
