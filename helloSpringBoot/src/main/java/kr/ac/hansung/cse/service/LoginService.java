package kr.ac.hansung.cse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.cse.dao.UserRepository;
import kr.ac.hansung.cse.model.User;

@Service
public class LoginService {
	@Autowired
	private UserRepository userRepository;

	/** name과 password가 일치하는 사용자가 DB에 있는지 확인하는 메서드
	 * @return false - 일치하는 사용자가 없는 경우 */
	public boolean validateUser(String name, String password) {
		User user = userRepository.findByName(name);

		if (user != null) {
			return password.equals(user.getPassword());
		} else
			return false;
	}
}
