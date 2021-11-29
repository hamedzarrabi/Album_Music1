package com.hamed;

import com.hamed.model.Album;
import com.hamed.repository.AlbumRepository;
import com.hamed.service.AlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.annotation.Rollback;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

@SpringBootTest
class AlbumMusicApplicationTests {

	@Autowired private AlbumService albumService;

//	@Test
//	@Rollback(value = false)
//	void testInsertFile() throws IOException {
//
//		File file = new File("G:\\Theme-Site\\Flattern\\changelog.TXT");
//
//		Album album = new Album();
//		album.setName(file.getName());
//		byte[] bytes = Files.readAllBytes(file.toPath());
//		album.setMusic_album(bytes);
//
//		long fileSize = bytes.length;
//		album.setSize(fileSize);
//
//		album.setDatePublish(new Date());
//	}

	@Test
	public void testInserAlbum(){
		Album album = new Album();

		album.setName("homayon");
		album.setPrice(343.21);
		album.setDatePublish(new Date());

		albumService.save(album);
	}

}
