package BigProject;

import BigProject.services.CmdLineService;
import BigProject.services.impl.ClientServiceImpl;
import BigProject.services.impl.MenuServiceImpl;
import BigProject.services.impl.ProductServiceDb;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        CmdLineService cmdLineService = new CmdLineService(new ClientServiceImpl(), new ProductServiceDb(), new MenuServiceImpl());
        cmdLineService.goMainMenu();
    }
}