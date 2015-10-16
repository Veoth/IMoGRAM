package ivvq

import grails.transaction.Transactional

@Transactional
class UserService {
    /**
     * Gets the informations concerning the user logging in
     * @param username
     * @param password
     * @return
     */
    User getUserLoggingIn(String username, String password){
        if(username != null && password != null ) {
            username = username.trim()
            password = password.trim()
        }
        return User.findByUsernameAndPassword(username,password)
    }

    List<ItemUser> getAllUserItem(User user) {

        List<ItemUser> collections = null

        if (User.findByUsername(user.username)) {
            collections = ItemUser.findAllByUser(user)
        }

        return collections
    }
}
