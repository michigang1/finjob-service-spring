package com.springcourse.findjob.service

import com.springcourse.findjob.models.Vacancy
import com.springcourse.findjob.repository.GeneralRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GeneralServiceImpl(@Autowired private val generalRepository: GeneralRepository) : GeneralService {
    override fun createVacancy(vacancy: Vacancy) = generalRepository.createVacancy(vacancy)

    override fun upgradeVacancy(id: Int, vacancy: Vacancy) = generalRepository.upgradeVacancy(id, vacancy)

    override fun deleteVacancy(id: Int) = generalRepository.deleteVacancy(id)

    override fun getAllVacancies() = generalRepository.getAllVacancies()
    override fun getCompanyVacancies(name: String): List<Vacancy> {
        return generalRepository.getAllVacancies().filter {
            it.description?.company?.lowercase() == name.lowercase()
        }
    }

    override fun getVacancyById(id: Int): Vacancy {
        return generalRepository.getAllVacancies().find {
            it.id == id
        } ?: throw Exception("Vacancy with id=$id not found")
    }

    override fun getByKeyWordVacancy(keyWord: String) = generalRepository.getByKeyWordVacancy(keyWord)
}
