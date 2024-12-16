package com.alex.bst.bst_app;

	import com.alex.bst.controller.BinarySearchTreeController;
	import com.alex.bst.service.BinarySearchTreeService;
	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.http.ResponseEntity;
	
	import java.util.List;
	
	import static org.assertj.core.api.Assertions.assertThat;
	import static org.mockito.Mockito.when;
	
	@SpringBootTest
	class BstAppApplicationTests {
	
		@Autowired
		private BinarySearchTreeController controller;
	
		@Autowired
		private BinarySearchTreeService service;
	
		@Test
		void contextLoads() {
			// Ensure the controller is loaded properly
			assertThat(controller).isNotNull();
		}
	
		@Test
		void testProcessNumbers() {
			// Mock input and expected output
			List<Integer> inputNumbers = List.of(15, 10, 20, 8, 12);
			String mockTree = "{\"value\":15,\"left\":{\"value\":10,\"left\":{\"value\":8,\"left\":null,\"right\":null},\"right\":{\"value\":12,\"left\":null,\"right\":null}},\"right\":{\"value\":20,\"left\":null,\"right\":null}}";
	
			// Define behavior of the mocked service
			when(service.createBinarySearchTree(inputNumbers)).thenReturn(mockTree);
	
			// Call the controller's endpoint
			ResponseEntity<String> response = controller.processNumbers(inputNumbers);
	
			// Verify the response
			assertThat(response.getBody()).isEqualTo(mockTree);
		}
	
		@SuppressWarnings("null")
		@Test
		void testPreviousTrees() {
			// Mock data
			var storedTree = new com.alex.bst.model.StoredTree();
			storedTree.setId(1L);
			storedTree.setInputNumbers("[15, 10, 20, 8, 12]");
			storedTree.setTreeStructure("{\"value\":15,\"left\":{\"value\":10},\"right\":{\"value\":20}}");
	
			// Define behavior of the mocked service
			when(service.getAllPreviousTrees()).thenReturn(List.of(storedTree));
	
			// Call the controller's endpoint
			ResponseEntity<List<com.alex.bst.model.StoredTree>> response = controller.getPreviousTrees();
	
			// Verify the response
			assertThat(response.getBody()).hasSize(1);
			assertThat(response.getBody().get(0).getInputNumbers()).isEqualTo("[15, 10, 20, 8, 12]");
		}
	}
 

