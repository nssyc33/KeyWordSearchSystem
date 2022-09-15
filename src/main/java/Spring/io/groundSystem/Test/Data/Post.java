package Spring.io.groundSystem.Test.Data;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Getter
@Setter
public class Post {

	@Id
	private Long id;
	
	private String name;
}
