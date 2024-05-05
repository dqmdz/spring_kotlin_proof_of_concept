package org.dqmdz.proof_of_concept.repository

import org.dqmdz.proof_of_concept.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>;