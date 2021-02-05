package BusinessLogic;

import DomainModel.RepositoryMenu;

// TODO: Singleton
// login attraverso l'interfaccia prende l'ID e chiama il costruttore del RestaurantManagerPageController

public class RestaurantManagerPageController {
	private String id=null;
	private RepositoryMenu repositoryMenu;
	
	public RestaurantManagerPageController(String id, RepositoryMenu repositoryMenu) {
		this.id = id;
		this.repositoryMenu = repositoryMenu;
	}
	
}
